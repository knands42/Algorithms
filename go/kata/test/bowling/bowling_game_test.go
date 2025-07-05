package bowling

import (
	"github.com/knands42/algs/kata/bowling"
	. "github.com/onsi/ginkgo/v2"
	"github.com/onsi/gomega"
)

var _ = Describe("Kata/Bowling/bowling_game", func() {
	It("should strike", func() {
		// given
		game := bowling.NewBowlingGame()

		// when
		game.Roll(10)

		// then
		gomega.Expect(game.DidItStrike()).To(gomega.Equal(true))
		gomega.Expect(game.Score()).To(gomega.Equal(20))
	})

	It("should spare", func() {
		// given
		game := bowling.NewBowlingGame()

		// when
		game.Roll(5)
		game.Roll(5)

		// then
		gomega.Expect(game.DidItSpare()).To(gomega.Equal(true))
		gomega.Expect(game.Score()).To(gomega.Equal(15))
	})

	It("should not score all pins", func() {
		// given
		game := bowling.NewBowlingGame()

		// when
		game.Roll(5)
		game.Roll(3)

		// then
		gomega.Expect(game.DidItStrike()).To(gomega.Equal(false))
		gomega.Expect(game.DidItSpare()).To(gomega.Equal(false))
		gomega.Expect(game.Score()).To(gomega.Equal(8))
	})
})
