package arrays.strings;

public class ImageRotation
{
	static int[][] image = { { 0, 1, 2, 3, 4 }, { 0, 1, 2, 3, 4 }, { 0, 1, 2, 3, 4 }, { 0, 1, 2, 3, 4 }, { 0, 1, 2, 3, 4 } };

	public static void main(String[] args)
	{
		rotateImage90(image);
	}

	private static void print(int[][] image)
	{
		int N = image.length;
		StringBuilder sb = new StringBuilder(N * N);
		sb.append('\n');
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
				sb.append(image[i][j]).append(' ');
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void rotateImage90(int[][] matrix)
	{
		System.out.println("Before rotation");
		print(matrix);

		int N = matrix.length;

		for (int layer = 0; layer <= N / 2; layer++)
		{
			int first = layer;
			int last = N - 1 - first;
			for (int offset = first; offset < last; offset++)
			{
				int buffer = matrix[first][first + offset];

				matrix[first][first + offset] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[first + offset][last];
				matrix[first + offset][last] = buffer;
			}

		}
		
		System.out.println("After rotation");
		print(matrix);

	}
}
