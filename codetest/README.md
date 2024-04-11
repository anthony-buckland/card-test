**Poker Hand Calculator**

I do not play poker; never have, so I needed to do a good bit of learning before I even started to code. The suggested link to [Wikipedia](https://en.wikipedia.org/wiki/List_of_poker_hands) was basically my guide - thank you for providing the link.

*Requirements to run this code*

I used `OpenJDK 20` for Java. It should be backwards compatible to around Java 8. You'll need `gradle` too. 

*Run the project*

I typically use the command line, in my case Mac `Terminal`.

Ideally check out the unit tests, but in any IDE or console with `gradle` installed, it should run with `./gradlew clean build` or the Windows equivalent `gradlew clean build`.

*Terminal/Console input*

Input into the system can be entered on the command line using this simple language:

Use the suit title character, eg H, C, D, S, (Hearts, Clubs, Diamonds, Spades) combined with either the number of the card or the initial of the type of card. Please lead with the suit. 

eg:
`2 Spades -> S2`
`7 Clubs -> C7`
`Knight Hearts -> HK`

Separate the cards in each hand by a space:

`KS QC 7D 10H JOKER`

(As I have said I know nothing about poker! Some games allow Jokers)


*Wikipedia*

There are also a number of versions of poker, so I am not sure which rules to follow. I chose to use the [Wikipedia](https://en.wikipedia.org/wiki/List_of_poker_hands) examples. It may not be the best resource, it is not clear on the rôle of Jokers. 

*NOTES*

I used the Lombok plugin, because I like just writing `var` rather than the tedious Java `SomeType thing = new SomeType()` style. I did not use it other than for that simple convenience.

As mentioned above I do not play poker, so I have no idea what the rules about Jokers are. In fact I have learnt everything about poker that I know in the past few days.

Not sure if we are playing with multiple packs, as in a casino. I did not test for, say more than 5 Aces in a hand, impossible in a single pack game.

Shot myself in the foot somewhat by using enums for the Scores, I could have used constants instead.

I did do this entirely TDD style, even though my normal approach would be to develop the test and the system under code at pretty much the same time.


*ATTRIBUTIONS*

I got a lot of inspiration for the setup from the following sites:

* Stack Exchange's [code review](https://codereview.stackexchange.com/questions/36916/weekend-challenge-poker-hand-evaluation).
* [Dev.to](https://dev.to/miketalbot/real-world-javascript-map-reduce-solving-the-poker-hand-problem-3eie)
* [Medium](https://joshgoestoflatiron.medium.com/july-17-evaluating-poker-hands-with-lookup-tables-and-perfect-hashing-c21e056da130)
* [Medium](https://blog.stackademic.com/building-a-simple-poker-hand-evaluator-in-c-1bb81676c25c)
* And last but not least, https://open.spotify.com/

That was useful for the basics, but when I went into business logic you can see I greatly diverged from the logic presented in these various tutorials.







