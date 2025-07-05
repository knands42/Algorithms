package bowling

import (
	"log"
	"math/rand"
)

type GameSettings struct {
	players []Player
	game    *BowlingGame

	frames int

	currentPlayer int
	playerScore   map[int]int
}

func NewGameSettings(players ...Player) *GameSettings {
	if len(players) == 0 {
		log.Println("No players provided")
		return nil
	}

	return &GameSettings{
		players: players,
		game:    NewBowlingGame(),

		frames: 10,

		currentPlayer: 0,
		playerScore:   make(map[int]int),
	}
}

func (gs *GameSettings) Play() {
	if gs.IsGameFinished() {
		log.Println("Game finished")
		return
	}

	gs.rollUntilFinish(10)
	gs.game = NewBowlingGame()
	for !gs.isAnyRemainingPlayer() {
		gs.GetNextPlayer()
		gs.rollUntilFinish(10)
	}

	gs.prepareAnotherFrame()
	gs.frames -= 1
}

func (gs *GameSettings) prepareAnotherFrame() {
	gs.currentPlayer = 0
	gs.game = NewBowlingGame()
}

func (gs *GameSettings) GetNextPlayer() Player {
	gs.currentPlayer = (gs.currentPlayer + 1) % len(gs.players)
	return gs.players[gs.currentPlayer]
}

func (gs *GameSettings) GetCurrentPlayer() Player {
	return gs.players[gs.currentPlayer]
}

func (gs *GameSettings) GetRemainingFrames() int {
	return gs.frames
}

func (gs *GameSettings) IsGameFinished() bool {
	return gs.frames == 0
}

func (gs *GameSettings) GetScore() map[int]int {
	return gs.playerScore
}

func (gs *GameSettings) rollUntilFinish(pinsRemaining int) int {
	for {
		currPlayer := gs.GetCurrentPlayer()
		pinsTakeDown := rand.Intn(pinsRemaining + 1)

		gs.game.Roll(pinsTakeDown)

		if isFinished, result := gs.game.GameResult(); isFinished {
			if _, ok := gs.playerScore[currPlayer.Id]; !ok {
				gs.playerScore[currPlayer.Id] = result
			} else {
				gs.playerScore[currPlayer.Id] += result
			}
			return result
		} else {
			return gs.rollUntilFinish(pinsRemaining - pinsTakeDown)
		}
	}
}

func (gs *GameSettings) isAnyRemainingPlayer() bool {
	return len(gs.players)-1 == gs.currentPlayer
}
