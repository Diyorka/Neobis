SELECT customers.id, customers.name
FROM customers
LEFT JOIN locations on locations.id_customers=customers.id
WHERE locations.locations_date is NULL
ORDER BY customers.id;