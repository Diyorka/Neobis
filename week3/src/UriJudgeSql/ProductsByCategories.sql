SELECT categories.name, SUM(products.amount) as sum
FROM products, categories
WHERE categories.id=products.id_categories
GROUP BY categories.name;
