SELECT movies.id, movies.name FROM movies
JOIN genres on genres.id=id_genres
WHERE genres.description='Action';