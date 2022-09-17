SELECT id, name FROM products
WHERE id_categories
in (SELECT id FROM Categories WHERE SUBSTR(name,1,5)='super');