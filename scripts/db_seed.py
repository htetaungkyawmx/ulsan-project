# db_seed.py
import os
from sqlalchemy import create_engine, text
from dotenv import load_dotenv

# Load environment variables from .env file
load_dotenv()

# Get database details from environment variables
DB_HOST = os.getenv("DB_HOST", "localhost")
DB_PORT = os.getenv("DB_PORT", "3306")
DB_NAME = os.getenv("DB_NAME", "db_aioceaneye_java")
DB_USERNAME = os.getenv("DB_USERNAME", "root")
DB_PASSWORD = os.getenv("DB_PASSWORD", "")

DATABASE_URL = f"mysql+pymysql://{DB_USERNAME}:{DB_PASSWORD}@{DB_HOST}:{DB_PORT}/{DB_NAME}"

# Connect to the database
engine = create_engine(DATABASE_URL)

# Seed data into the database
def seed_database():
    try:
        with engine.connect() as conn:
            print("Connected to the database.")

            # Example: Create a table and insert some data
            conn.execute(text("""
                CREATE TABLE IF NOT EXISTS sample_data (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    value INT NOT NULL
                )
            """))
            conn.execute(text("""
                INSERT INTO sample_data (name, value) VALUES
                ('Example 1', 100),
                ('Example 2', 200)
                ON DUPLICATE KEY UPDATE value = VALUES(value)
            """))
            print("Database seeded successfully.")
    except Exception as e:
        print("Error seeding the database:", str(e))

if __name__ == "__main__":
    seed_database()
