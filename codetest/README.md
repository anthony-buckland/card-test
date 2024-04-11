
*WikiPedia*

I do not play poker; never have, so I needed to do a good bit of learning before I even started to code. The suggested link to [Wikipeadia](https://en.wikipedia.org/wiki/List_of_poker_hands) was basically my guide - thank you for providing the link.


*NOTES*

I got a lot of inspiration for the setup from a Stack Exchange [code review](https://codereview.stackexchange.com/questions/36916/weekend-challenge-poker-hand-evaluation). That was useful for the basics, but when I went into business logic you can see I greatly diverged from the logic presented there.

Not sure if we are playing with multiple packs, as in a casino. I did not test for, say more than 5 Aces in a hand, impossible in a single pack game.

Shot myself in the foot somewhat by using enums for the Scores

I did do this entirely TDD style, even though my normal approach would be to develop the test and the system under code at pretty much the same time.