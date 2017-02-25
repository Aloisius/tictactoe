# Tic-Tac-Toe

A simple command-line tic-tac-toe program written in Java. The human player always goes first.

## To Do

### version 0

Estimated time: 30 mins

Writing this document and a little research.

### version 1

Estimated time: 30 mins

Simple random player & interactive player

Classes:

* Player
* RandomPlayer
* InteractivePlayer
* GameBoard
* Main

Pseudo-code:

```
GameBoard board
CROSS = 'X'
NAUGHT = 'O'
UNPLAYED = ' '
InteractivePlayer player(CROSS)
RandomPlayer opponent(NAUGHT)

while !board.gameover():
  player.playMove(board)
  if board.gameover():
    break
  opponent.playMove(board)
  print(board)

if board.win():
  print("Computer won")
elsif board.tie():
  print("Tie")
else:
  print("World has ended")

class GameBoard:
    char state[9] = '         '

    won()
    draw()
    validMoves()
    set(pos, mark)
    get(pos)
    gameover()

    state()
    toString():


class Player:
    char mark
    Gameboard board

    playMove()
    mark()

class InteractivePlayer:
  playMove:
    while true:
      move = prompt("move : ")
      if move < 1 || > 9:
        print("must be between 1-9")
        continue

      move--

      if !board.availableMove(move):
        print("not available")

      break

    board.set(move, mark)
```

### version 2:

Estimated time: 90 mins

Add a slow intelligent player using a negamax since I don't trust
myself to get a heuristic version right the first time. Ignore depth
of negamax since there are only evaluate 7 moves deep anyway which
is slow, but it will simplify the heuristic value of the node algorithm 
significantly.

negamax psuedocode from wikipedia:

```
  function negamax(node, depth, color)
     if depth = 0 or node is a terminal node
         return color * the heuristic value of node

    bestValue := −∞
    foreach child of node
        v := −negamax(child, depth − 1, −color)
        bestValue := max( bestValue, v )
    return bestValue

  # Initial call for Player A's root node
  rootNegamaxValue := negamax( rootNode, depth, 1)
  rootMinimaxValue := rootNegamaxValue

  # Initial call for Player B's root node
  rootNegamaxValue := negamax( rootNode, depth, −1)
  rootMinimaxValue := −rootNegamaxValue
```

Classes:

* NegamaxPlayer
* NegamaxScore


pseudocode:

```

class NegamaxScore:
  score
  move
  
  NegamaxScore(score, move):


class NegamaxPlayer:
    init(opponent):
      players[2] = { this, opponent }

    playMove(board):
      move = negamax(board, 1)

    negamax(board, color):
      if depth == 0 or board.gameover():
        return color*score(board, players[color + 1])

      bestValue = new NegamaxScore(-infinitish, invalidMove)
      foreach move in board.availableMoves():
        childBoard = new BoardGame(board)
        childBoard.set(move, player[color + 1])
        childScore = negamax(childBoard, −color)
        if bestValue.score > -childScore.score:
          bestValue.score = -childScore.score
          bestValue.move = move

      return bestValue

    score(board, player):
      if board.lost(player):
        return -bigNumber

      if board.winner(player)
        return bigNumber

      return 0
```

### version 3:

Estimated time: 60 mins

Use the intelligent player and a manual player to play the whole game
space and output a precomputed moves list for a PrecomputedPlayer.

PrecomputedMoves would probably just be a HashMap. Or I could just build a
giant switch statement since game state will fit into a 32-bit
integer (9 places * 2 bits).


Classes:

PrecomputedGenerator
PrecomputedPlayer
PrecomputedMoves

Pseudo-code:

```
PrecomputedGenerator:
  Map<BoardState, int> generatedMoves

  playRecusively(board, player, opponent):
    foreach move in board.validMoves():
      GameBoard boardCopy = new GameBoard(board)
      player.playMove(boardCopy, move)

      char[9] boardState = boardCopy.state
      if generatedMoves.has(boardState):
        continue

      return if boardCopy.done()
      move = opponent.getMove(boardCopy)

      generatedMoves.put(boardState, move)
      oPlayer.playMove(boardCopy, move)
      playRecusively(boardCopy, player, opponent)

  writePrecomputedMovesFile:
  	write(PrecomputedMoves.java)

  main:
    GameBoard board
    InteractivePlayer player(CROSS)
    NegamaxPlayer opponent(NAUGHT)

    playRecusively(board, player, opponent)
    writePrecomputedMovesFile()
 ```
 
### version infinity:

Estimated time: infinite

Stuff to do if I have time left over...

* Add more things to this list
