package score_cor

import "github.com/knands42/algs/kata/bowling/gameiface"

type RollHandler interface {
	SetNext(RollHandler)
	Handle(gameiface.Game, int)
}
