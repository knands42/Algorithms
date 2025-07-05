package score_cor

import (
	"math"

	"github.com/knands42/algs/kata/bowling/gameiface"
)

type StrikeHandler struct {
	BaseHandler
}

func (handler *StrikeHandler) Handle(game gameiface.Game, pinsTakeDown int) {
	pinsRemaining := game.RemainingPins() - int(math.Abs(float64(pinsTakeDown)))

	if game.CurrentRoll() == 0 && pinsRemaining == 0 {
		game.SetScore(NUM_OF_PINS * 2)
		game.SetStrike()
	} else {
		handler.CallNext(game, pinsTakeDown)
	}
}
