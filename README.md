
# Liste de Pokemon
Ce projet est une liste référencent des pokémons. En cliquant sur les pokémons on peut obtenir des détails sur : leur type, leur faiblesse, leur évolution suivante (s'il y en a une) et leur évolution précédente (s'il y en a une). Je peux également ajouter un nouveau pokemon et faire une recherche particulière. J'ai ajouter une barre de navigation.
Au cours de ce projet j'ai rencontré différents problèmes :

- Le premier problème que j'ai résolu était que l'application ne fonctionnait plus quand je sélectionnai un pokémon sans évolution suivante ou sans sous-évolution pour régler ce problème j'ai du insérer le code suivant : 
```
public PokemonEvolutionAdapter(Context context, List<Evolution> evolutions) {
        this.context = context;
        if(evolutions != null)
            this.evolutions = evolutions;
        else
            this.evolutions = new ArrayList<>();
    }
 ```
    
- Le second problème est que la 3eme évolution d'un pokémon (s'il en a 3) affiche directement la première sous évolution dans les détails, cela est certainement dû à un problème d'id (problème non résolu)

- Le troisième problème rencontré est lors de l'ajout d'un nouveau pokemon. L'ajout ne se fait pas joliment à la liste.(Problème non résolu)


Images : 

![Screen #1](https://user-images.githubusercontent.com/47032498/71251920-d9048100-2323-11ea-8ff3-a2e6a0029300.jpg)


![Screen #2](https://user-images.githubusercontent.com/47032498/71252026-2680ee00-2324-11ea-80d9-2e99e53b0d45.jpg)



 
 
 
