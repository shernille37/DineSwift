import mysql.connector

# Define your categories
categories = [
    'Base',
    'Binder',
    'Thickener',
    'Emulsifier',
    'Leavening Agent',
    'Moisturizer',
    'Preservative',
    'Flavoring Agent',
    'Colorant',
    'Sweetener',
    'Stabilizer',
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
            "INSERT INTO ingredient_category (id, name) VALUES (%s,%s)", (id,category,)
        )
        cursor.execute(
            "UPDATE ingredient_category_seq SET next_val = %s WHERE next_val = %s", (id+1, id,)
        )
        id += 1

    conn.commit()
    print("Success")

except mysql.connector.Error as err:
    print(f"Error: {err}")

finally:
    if cursor:
        cursor.close()
    if conn:
        conn.close()
