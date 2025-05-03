import mysql.connector

# Define your categories
categories = [
    'Fruits',
    'Vegetables',
    'Dairy',
    'Meat',
    'Seafood',
    'Grains',
    'Beverages',
    'Snacks',
    'Spices',
    'Bakery'
]

# Database connection config
config = {
    'user': 'root',
    'password': 'SKL.Licud2001',
    'host': 'localhost',
    'database': 'food_delivery_system'
}

try:
    # Connect to MySQL
    conn = mysql.connector.connect(**config)
    cursor = conn.cursor()

    id = 1

    # Insert categories
    for category in categories:
        cursor.execute(
            "INSERT INTO category (id, name) VALUES (%s,%s)", (id,category,)
        )
        id += 50

    conn.commit()
    print("Categories inserted successfully.")

except mysql.connector.Error as err:
    print(f"Error: {err}")

finally:
    if cursor:
        cursor.close()
    if conn:
        conn.close()
