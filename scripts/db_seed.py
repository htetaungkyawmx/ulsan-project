import sys
import os

# Add the project root directory to the Python path
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from sqlalchemy import text
from sqlalchemy.orm import Session
from passlib.context import CryptContext
from database import SessionLocal, engine, Base
from models.Role import Role
from models.Permission import Permission
from models.role_permission import role_permission
from models.user_model import UserModel

def reset_database(db: Session):
    # Delete all records and reset auto-increment values
    db.query(role_permission).delete()
    db.query(PermissionModel).delete()
    db.query(RoleModel).delete()
    db.query(UserModel).delete()
    db.commit()

    db.execute(text("ALTER TABLE roles AUTO_INCREMENT = 1"))
    db.execute(text("ALTER TABLE permissions AUTO_INCREMENT = 1"))
    db.execute(text("ALTER TABLE users AUTO_INCREMENT = 1"))
    db.commit()

def seed_roles(db: Session):
    roles = [
        {"name": "admin", "description": "Full access to all system features."},
        {"name": "pilot", "description": "Can manage drone flights."},
        {"name": "mechanic", "description": "Can perform drone maintenance."},
        {"name": "captain", "description": "Can manage vessel operations."},
        {"name": "company", "description": "Can manage company-related data."}
    ]
    db.add_all([RoleModel(name=role['name'], description=role['description']) for role in roles])
    db.commit()

def seed_permissions(db: Session):
    permissions = [
        {"name": "create_company", "description": "Allow user to create a company."},
        {"name": "read_company", "description": "Allow user to view company information."},
        {"name": "update_company", "description": "Allow user to update company details."},
        {"name": "delete_company", "description": "Allow user to delete a company."},
        # Add other permissions here...
    ]
    db.add_all([PermissionModel(name=perm['name'], description=perm['description']) for perm in permissions])
    db.commit()

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

def seed_demo_users(db: Session):
    demo_users = [
        {"username": "Admin", "email": "admin@marine-drone.co.kr", "password": "password123", "role_id": 1},
        {"username": "Pilot", "email": "pilot@marine-drone.co.kr", "password": "password123", "role_id": 2},
        {"username": "Company", "email": "company@marine-drone.co.kr", "password": "password123", "role_id": 5},
        {"username": "Captain", "email": "captain@marine-drone.co.kr", "password": "password123", "role_id": 4},
        {"username": "Mechanic", "email": "mechanic@marine-drone.co.kr", "password": "password123", "role_id": 3},
    ]

    for user in demo_users:
        hashed_password = pwd_context.hash(user["password"])
        db_user = UserModel(
            username=user["username"],
            email=user["email"],
            password=hashed_password,
            role_id=user["role_id"]
        )
        db.add(db_user)
    db.commit()

def seed_role_permissions(db: Session):
    roles = db.query(RoleModel).all()
    permissions = db.query(PermissionModel).all()

    role_permissions_map = {
        "admin": [perm.name for perm in permissions],  # Admin gets all permissions
        "pilot": ["create_flight_log", "read_flight_log"],
        "mechanic": ["create_maintenance", "read_maintenance"],
        "captain": ["create_report", "read_report"],
        "company": ["create_company", "read_company"]
    }

    for role in roles:
        if role.name in role_permissions_map:
            assigned_permissions = [perm for perm in permissions if perm.name in role_permissions_map[role.name]]
            role.permissions = assigned_permissions
    db.commit()

def create_tables():
    Base.metadata.create_all(bind=engine)

def main():
    with SessionLocal() as db:
        create_tables()  # Create tables first
        reset_database(db)  # Reset the database
        seed_roles(db)  # Seed roles
        seed_permissions(db)  # Seed permissions
        seed_role_permissions(db)  # Seed role permissions
        seed_demo_users(db)  # Seed users

if __name__ == "__main__":
    main()
