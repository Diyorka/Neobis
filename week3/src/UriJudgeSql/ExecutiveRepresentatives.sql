SELECT products.name, providers.name FROM products
JOIN providers on providers.id=id_providers
WHERE id_categories=6;