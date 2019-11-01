package com.nqueens.solver

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class BoardIntSpec extends Specification {

	def "solve works for n=#n without any constraints"() {
		given:
			def board = new Board(n)

		expect:
			board.solve(Collections.emptyList()) == isPossible
			board.print()
			if(isPossible) assert board.isEqualTo(solution)

		where:
			n   |   isPossible  |   solution
			2   |   false       |   []
			3   |   false       |   []
			4   |   true        |   [[0,0,1,0],[1,0,0,0],[0,0,0,1],[0,1,0,0]]
			8   |   true        |   [[1,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0],[0,0,0,0,1,0,0,0],[0,0,0,0,0,0,0,1],[0,1,0,0,0,0,0,0],[0,0,0,1,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,1,0,0,0,0,0]]
	}

	def "solve works for n=#n with no 3 queens on the same line"() {
		given:
			def board = new Board(n)

		expect:
			board.solve(Arrays.asList(Constraint.NO_THREE_QUEENS_SAME_LINE)) == isPossible
			board.print()
			if(isPossible) assert board.isEqualTo(solution)

		where:
			n   |   isPossible  |   solution
			2   |   false       |   []
			3   |   false       |   []
			4   |   true        |   [[0,0,1,0],[1,0,0,0],[0,0,0,1],[0,1,0,0]]
			8   |   true        |   [[0,0,0,0,1,0,0,0],[0,0,0,0,0,0,1,0],[1,0,0,0,0,0,0,0],[0,0,0,1,0,0,0,0],[0,1,0,0,0,0,0,0],[0,0,0,0,0,0,0,1],[0,0,0,0,0,1,0,0],[0,0,1,0,0,0,0,0]]
	}
}
