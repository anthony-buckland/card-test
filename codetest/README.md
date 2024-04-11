
*WikiPedia*

I do not play poker; never have, so I needed to do a good bit of learning before I even started to code. The suggested link to [Wikipeadia](https://en.wikipedia.org/wiki/List_of_poker_hands) was basically my guide - thank you for providing the link.

There are also a number of versions of poker, so I am not sure which rules to follow. I chose to use the Wikipedia examples.


*NOTES*

I got a lot of inspiration for the setup from the following sites:

* Stack Exchange [code review](https://codereview.stackexchange.com/questions/36916/weekend-challenge-poker-hand-evaluation). 
* [Medium.com](https://joshgoestoflatiron.medium.com/july-17-evaluating-poker-hands-with-lookup-tables-and-perfect-hashing-c21e056da130)
* 
* 
* 
* https://open.spotify.com/



That was useful for the basics, but when I went into business logic you can see I greatly diverged from the logic presented in these.







Not sure if we are playing with multiple packs, as in a casino. I did not test for, say more than 5 Aces in a hand, impossible in a single pack game.

Shot myself in the foot somewhat by using enums for the Scores, I could have used constants instead.

I did do this entirely TDD style, even though my normal approach would be to develop the test and the system under code at pretty much the same time.