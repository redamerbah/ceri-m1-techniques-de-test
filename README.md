# Technique de test


# Nom et Prénom :
* ![namebadge](https://img.shields.io/static/v1?label=Nom&message=MERBAH%20Reda&color=white)
# Groupe
* ![groupbadge](https://img.shields.io/static/v1?label=Groupe&message=ILSEN-ALT-Gr2&color=yellow)
# badge Circeleci
* [![redamerbah](https://circleci.com/gh/redamerbah/ceri-m1-techniques-de-test.svg?style=svg)](https://app.circleci.com/pipelines/github/redamerbah)
# badge codecov
* [![codecov](https://codecov.io/gh/redamerbah/ceri-m1-techniques-de-test/branch/master/graph/badge.svg)](https://app.codecov.io/gh/redamerbah/ceri-m1-techniques-de-test)
# badge javadoc
* [![javadoc](https://javadoc.io/badge2/org.springframework/spring-core/javadoc.svg)](https://redamerbah.github.io/ceri-m1-techniques-de-test/)
# badge checkstyle
* ![Checkstyle](target/site/badges/checkstyle-result.svg)

## Rapport de TP6 :

Tout d'abord, nous avons entrepris des tests sur toutes les classes fournies. Dans ce TP6, notre objectif était de mettre à l'épreuve un code développé par une autre équipe de développement appelée la Team Rocket. Nous avons intégré leur implémentation à notre projet et procédé à des tests. Avant de commencer ces tests, j'ai pris le temps de comprendre le code en analysant les méthodes qui y étaient implémentées.

le test de la méthode 'getIv()' échoue et affiche une erreur. La raison en est que la classe RocketPokemonFactory enregistre brutalement IV = 1. Ainsi, lorsqu'un IV est passé en paramètre pour créer un Pokémon, il n'est pas pris en compte.

Il est donc essentiel de gérer correctement les IV. Nous constatons que les indices ne sont pas vérifiés (comme dans le TP3). L'indice doit être inférieur à 0 et supérieur à 150, et dans ce TP, nous avons un Pokémon mappé avec un indice de -1 sans qu'aucune exception ne soit levée, bien que l'indice soit inférieur à 0.

perspectives d'amélioration :
On pourrait envisager de tester si le remplacement du metadataprovider et des metadonnées a bien un impact. C'est à dire  vérifier qu'il ne suffit pas de déclarer ses propre métadonnées dans son PokemonFactory. On pourrait vérifier que le temps ne dépasse une certaine limite au vu du nombre important d'itération inutiles dans le générateur aléatoire de ma Team Rocket.

Ce TP6 marque la fin des TPs de technique de test, j'ai pu apprendre des choses sur les outils de test par exemple : JUnit et mockito, de la mésure de qualité de code afin de s'assurer que il est lisible, maintenable et testable en utilisant des outils de qualimétrie comme checkstyle et jacoco aussi de couverture de code en utilisant codeCove.
