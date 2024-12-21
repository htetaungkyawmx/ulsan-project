from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.orm import Session
from passlib.context import CryptContext
from database import SessionLocal, Base, engine
from models.role_model import RoleModel
from models.permission_model import PermissionModel
from models.role_permission import role_permission
from models.user_model import UserModel

pwd_context = CryptContext(schemes=["bcrypt"], deprecated="auto")

def reset_database(db: Session):
    try:
        db.query(role_permission).delete()
        db.query(PermissionModel).delete()
        db.query(RoleModel).delete()
        db.query(UserModel).delete()
        db.commit()
        print("Database reset successfully.")
    except SQLAlchemyError as e:
        print(f"Database reset failed: {e}")

# Other seeding functions follow the same structure
