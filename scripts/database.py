from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

# Correct your database URL
DATABASE_URL = "mysql+pymysql://root:password@localhost:3306/db_aioceaneye_java"

# Create the engine and session maker
engine = create_engine(DATABASE_URL, echo=True)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# Define the base class for models
Base = declarative_base()
