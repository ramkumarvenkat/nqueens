package com.nqueens.solver

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BoardIntSpec extends Specification {

	def "solve works for n=#n"() {
		given:
			def board = new Board(n)

		expect:
			board.solve() == isPossible
			board.print()
			if(isPossible) board.isEqualTo(solution)

		where:
			n   |   isPossible  |   solution
			2   |   false       |   []
			3   |   false       |   []
			4   |   true        |   [[0,0,1,0],[1,0,0,0],[0,0,0,1],[0,1,0,0]]
			8   |   true        |   [[1,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0],[0,0,0,0,1,0,0,0],[0,0,0,0,0,0,0,1],[0,1,0,0,0,0,0,0],[0,0,0,1,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,1,0,0,0,0,0]]
	}
}
