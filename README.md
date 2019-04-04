
# Liste de Pokemon
Ce projet est une liste référencent des pokémons. En cliquant sur les pokémons on peut obtenir des détails sur : leur type, leur faiblesse, leur évolution suivante (s'il y en a une) et leur évolution précédente (s'il y en a une).
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


Images : 











 ![screen_1.png](D:\ESIEA)                                        
 
 
 
 
 






























