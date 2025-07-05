package score_cor

import (
	"github.com/knands42/algs/kata/bowling/gameiface"
)

type CommonHandler struct {
	BaseHandler
}

func (handler *CommonHandler) Handle(game gameiface.Game, pinsTakeDown int) {
	game.SetScore(game.Score() + pinsTakeDown)
	handler.CallNext(game, pinsTakeDown)
}
