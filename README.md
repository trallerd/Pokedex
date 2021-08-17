
![](https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_pokecenter-128.png)
# Pokedex
O aplicativo é uma pokedex possui duas listas, uma geral de todos pokemons com possibilidade de ver seus detalhes e outra apenas com os favoritos.


### [Video Demo da Aplicação](https://www.youtube.com/watch?v=fwyRLzPuzik)


## Lista Geral

> Lista do nome dos pokemons é retornado pela [API](https://pokeapi.co/) ultilizando [Retrofit](https://square.github.io/retrofit/). Sendo possível realizar o scroll dos items retornados e clicar em um deles para ver seus detalhes.

## Detalhes

Contem informações básicas do pokemon:
* ID
* Nome
* Tipo (grass, fire, water)
* Abilidades
* Especie
* Altura
* Peso
* Foto

## Opção para favoritar ou desfavoritar esse pokemon
- Lista dos Favoritos
> Uma lista dos pokemons favoritados, podendo ver os detalhes igual na Lista Geral.
Essa lista deve esta disponível mesmo sem uma conexão com a internet, sendo possível utilizá-la normalmente.

- API
API para obter os dados: [API](https://pokeapi.co/)
Rota para a lista de pokemons: [Lista com Pokemons](https://pokeapi.co/api/v2/pokemon?limit=898&offset=0)
Rota para os detalhes do pokemon: [Pokemons Especifico](https://pokeapi.co/api/v2/pokemon/ivysaur)

- Função Favoritar
A função favoritar foi feita totalmente no aplicativo, ou seja, quando clicar em favoritar deve é salvo localmente ultilizando [ROOM](https://developer.android.com/jetpack/androidx/releases/room?gclsrc=ds&gclsrc=ds&gclid=CIHO9vLvs_ICFRUeHwodUhIGTw), aquele pokemon.



### About me
[![Github Badge](https://img.shields.io/badge/-Github-000?style=flat-square&logo=Github&logoColor=white&link=https://github.com/fagnerpsantos)](https://github.com/Trallerd)
[![Twitter Badge](https://img.shields.io/badge/-Twitter-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/trallerd)](https://twitter.com/trallerd)
[![Youtube Badge](https://img.shields.io/badge/-YouTube-ff0000?style=flat-square&labelColor=ff0000&logo=youtube&logoColor=white&link=https://www.youtube.com/channel/UCHmlPQF6AVr3y7fj7TE-7Hw)](https://www.youtube.com/channel/UCHmlPQF6AVr3y7fj7TE-7Hw)
