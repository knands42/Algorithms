package bowling_test

import (
	"github.com/knands42/algs/kata/bowling"
	. "github.com/onsi/ginkgo/v2"
	"github.com/onsi/gomega"
)

var _ = Describe("Kata/Bowling/game_settings", func() {
	It("should create game settings and get the current player", func() {
		// given
		player1 := bowling.Player{
			Id: 1,
		}
		player2 := bowling.Player{
			Id: 2,
		}
		game := bowling.NewGameSettings(player1, player2)

		// then
		currentPlayer := game.GetCurrentPlayer()

		// then
		gomega.Expect(currentPlayer).To(gomega.Equal(player1))
	})

	It("should create game settings and get the next player", func() {
		// given
		player1 := bowling.Player{
			Id: 1,
		}
		player2 := bowling.Player{
			Id: 2,
		}
		game := bowling.NewGameSettings(player1, player2)

		// then
		nextPlayer := game.GetNextPlayer()

		// then
		gomega.Expect(nextPlayer).To(gomega.Equal(player2))
	})

	It("should score after the first frame", func() {
		// given
		player1 := bowling.Player{
			Id: 1,
		}
		player2 := bowling.Player{
			Id: 2,
		}
		player3 := bowling.Player{
			Id: 3,
		}
		game := bowling.NewGameSettings(player1, player2, player3)

		// then
		game.Play()
		remainingFrames := game.GetRemainingFrames()
		score := game.GetScore()

		// then
		gomega.Expect(remainingFrames).To(gomega.Equal(9))
		gomega.Expect(score).To(gomega.HaveKey(player1.Id))
		gomega.Expect(score).To(gomega.HaveKey(player2.Id))
		gomega.Expect(score).To(gomega.HaveKey(player3.Id))
	})

	It("should play until game finish", func() {
		// given
		player1 := bowling.Player{
			Id: 1,
		}
		player2 := bowling.Player{
			Id: 2,
		}
		game := bowling.NewGameSettings(player1, player2)

		// then
		for i := 0; i < 10; i++ {
			game.Play()
		}
		remainingFrames := game.GetRemainingFrames()
		score := game.GetScore()
		isFinished := game.IsGameFinished()

		// then
		gomega.Expect(remainingFrames).To(gomega.Equal(0))
		gomega.Expect(score).To(gomega.HaveKey(player1.Id))
		gomega.Expect(score).To(gomega.HaveKey(player2.Id))
		gomega.Expect(isFinished).To(gomega.Equal(true))
	})
})
