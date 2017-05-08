# Backlog
[Home](./README.md)

- Ongoing Project Material.
- Software Product.
- Quality Assurance.
- Planning & Tracking.
- Review & Forward Planning.

This document will look at the items that need to be completed for the project to be successful.

- [x] [Iteration 1](##iteration-1)
- [ ] [Iteration 2](##iteration-2)
- [ ] [Iteration 3](##iteration-3)

# Backlog
- Items
  - [x] As a player I want KiwiIsland to have an introduction and options before I play so that I have better understanding of why I should play Kiwi Island.
    - [x] Introduction Screen
    - [x] Information Screen
    - [x] Settings Screen
  - [ ] As a player I want the GUI to have more visual appeal so that I can find the game more intricate and attractive when playing for longer periods of time.
    - [ ] The Game has updated Iconsets
      - [ ] The Game's terrain has updated visuals
      - [ ] The Game's predators have updated visuals
  - [ ] As a player I want the kiwi island map and it's occupants to be laid out differently for each game so that the game has more replay value as well as being more immersive.
  - [ ] As a player I want to be able to see the area around me in the map so that I can be more strategic in terms of my map positioning.
  - [ ] As a user I want to be able to trap predators and to kill them so that they are removed from the current game.
  - [ ] As a player I want the predators in the game to be able to move around kiwi island so that there is a more interactive and challenging experience.
  - [ ] As a player I want the predators to be able to hunt both me, the player and the kiwis so that I have a sense of urgency to find all the kiwis quickly as well as the tool's to protect myself.
  - [ ] As a player I want to be able to setup the size of the map before the game begins, so that the game can take more or less moves to complete.
  - [ ] As a Player i want to have the ability to choose a difficulty level to make the game more immersive as well as replay value.
  - [ ] As a player I want to know an overview of how to play the game before I begin playing the game so that the game is more beginner friendly.
  
## Iteration 1

### Planning 

![alt text](./images/image1.png "Class Diagram")

![alt text](./images/image2.png "Class Diagram 2")


### Results Matrix
|Things for ITERATION 1| Result on Sunday 16th |
|---|---|
| Setup size of the map.| Fields have been added to accept a size of the map however funtionality will need to be changed in the Game object that was not completely forseen with the difficulty around the game being built by a text field.|
| Size of the map scales.| Plan to implement this over the next few days however i anticipate it will be a buggy affair|
| Give an overview of how to play the game on first run.| This as well as cleaning up how the game started was achieved. |

### Retrospective

#### Andre
---
I am disappointed in our team's communication. We received a bad mark and we will need to work on our roles and expectations for this paper. I think we found the speed of this iterative approach for the portfolio very fast, especially given the time allocated with relation to all of our teams external commitments. While being our first project together I feel we can use these circumstances to improve our focus for the upcoming iterations to yield better results. I have been doing some work on the entry screen and contemplating the way to refactor or change the build flow of the game object. It is unscalable for KiwiIsland to be built by a single text file intertwined so tightly with the map and game. Passing the name through as I am doing with this commit is not the best change but it gives me the confidence to begin thinking about changing more of the initialiseIslandFromFile as well as providing a good branch point. I will continue to work on a new branch with a change in the games setup process. Looking especially into the setUpTerrain, setUpPlayer and potentially the setUpOccupants methods within the Game class. 
#### Ben
---
We need to improve our teams communication, and have to make changes for more effective team meeting. Since we recieved a bad mark for our planning, we now know that our current team meeting strategy isnt working at the moment. Time management for everyone is required as everyone in this paper is focusing more on the Research and development paper.

#### Alex
---
The communication within the team has been poor. It seems that more team meetings should be held to enable each team member to see where the project is overall. We also need to structure our meetings better, we can identify what each team member is working, what obstacles are in the way and how to overcome them. I think problems from the iteration planning phase have propagated through to iteration 1 such as having developer stories as user stories. This may have lead to confusion and a lack of cohesion within the team. Unfortunately, I think this project had a low priority on everyone's 'to do' list and got overlooked.

#### Overall
---
Our team didn't spend enough time together and on the project. We also failed to meet the assignment spec. Going forward we will address these issues by setting more time for meetings. Completing more work. Making sure the work meets the courses guidelines. And clearly documenting our process with an improved system.

### Specific Feedback
Clear table of contents of deliverables.
Acceptance tests for all User Stories.
Improve Commit Messages.
More Software Added.

## Iteration 2

#### Planning

The tasks we wish to achieve in iteration 2 are outlined below.

- [ ] Dynamic map (L)
  As a User, I want the map to be different on each play, so that each game is unique.
  As a User, I want to be able to set the size of the map, so that each game 

- [ ] Semi Random Terrain (M)
  As a User, I want the map to represent a Island but to have differing

- [ ] Random Spawn Location of Player, Predator, Traps/Hazards and Objects (XL)

- [ ] Icons for occupants (M)

- [ ] Icons for player (S)

- [ ] Improved rendering for terrains (M)

### Meeting 4/05

Ben is working on overhauling the UI to replace the Strings that represent the terrain. His changes will impact the ability for the code to run in the short term. He will create new branch while he works on this task.

We plan for the short term to keep the text file, Andre and Alex will look at manipulating the text file to enable the map to be more dynamic. They will work on devInitChange branch.

## Bugs

Description | Solved (How) | When
--- | --- | ---

## Iteration 3
