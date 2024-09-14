# shop-backend

## Back-end

Développer un back-end permettant la gestion de produits définis plus bas.
Vous pouvez utiliser la technologie de votre choix parmi la liste suivante :

- Java/Spring Boot


Le back-end doit gérer les API suivantes :

| Resource           | POST                  | GET                            | PATCH                                    | PUT | DELETE           |
| ------------------ | --------------------- | ------------------------------ | ---------------------------------------- | --- | ---------------- |
| **/products**      | Create a new product  | Retrieve all products          | X                                        | X   |     X            |
| **/products/:id**  | X                     | Retrieve details for product 1 | Update details of product 1 if it exists | X   | Remove product 1 |

Un produit a les caractéristiques suivantes :

``` typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  image: string;
  category: string;
  price: number;
  quantity: number;
  internalReference: string;
  shellId: number;
  inventoryStatus: "INSTOCK" | "LOWSTOCK" | "OUTOFSTOCK";
  rating: number;
  createdAt: number;
  updatedAt: number;
}
```

Le back-end créé doit pouvoir gérer les produits dans une base de données SQL/NoSQL ou dans un fichier json.

## Bonus

Vous pouvez ajouter des tests Postman ou Swagger pour valider votre API


## Solution

Accéder à l'url ==> http://localhost:8080/swagger-ui.html a fin de tester les apis Products crées

  Ou Sinon :

Avec Postman ==> 

    - GET : http://localhost:8080/products ==> récuperer la liste des produits
    - POST : http://localhost:8080/products ==> ajouter un nouveau produit
    - GET : http://localhost:8080/products/{id} ==> récuperer un produit avec son identifiant
    - PATCH : http://localhost:8080/products/{id} ==> mettre à jour un produit via son identifiant ID
    - DELETE : http://localhost:8080/products/{id} ==> supprimer un produit par son ID


https://web.postman.co/workspace/My-Workspace~db8a6863-d72c-4501-8c85-537bb0e2f03d/request/19628363-4afc950c-ab30-44e4-901e-67297510d287?action=share&source=copy-link&creator=19628363
https://web.postman.co/workspace/My-Workspace~db8a6863-d72c-4501-8c85-537bb0e2f03d/request/19628363-61ddc3d2-3659-46a0-bacf-8e80e24a0990?action=share&source=copy-link&creator=19628363
