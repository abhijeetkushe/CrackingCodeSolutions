package moderate;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class TicTacToe
{

	
	static Set<Integer> winners = new HashSet<>();

	static boolean hasWon(int a)
	{
		return winners.contains(a);
	}

	static enum Move
	{
		X, O, Nil
	};

	static boolean hasWon(Move[][] board, int i, int j)
	{
		Move move = board[i][j];

		IntStream boardDim = IntStream.range(0, 10);

		boolean horizontal = boardDim.anyMatch(x -> board[i][x] != move) == false;

		boolean vertical = boardDim.anyMatch(x -> board[x][j] != move) == false;

		boolean diagonal = i == j && boardDim.anyMatch(x -> board[x][x] != move) == false;

		return horizontal && vertical && diagonal;

	}

	public static void main(String[] args)
	{

	}
}
