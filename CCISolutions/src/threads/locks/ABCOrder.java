package threads.locks;

import java.util.concurrent.Semaphore;

public class ABCOrder
{
	public static void main(String[] args)
	{
		Semaphore a_semaphore = new Semaphore(0,true);
		Semaphore b_semaphore = new Semaphore(0,true);
		Semaphore c_semaphore = new Semaphore(1,true);
		Thread a = new Thread()
		{

			public void run()
			{
				try
				{
					c_semaphore.acquire();
					System.out.println("a");
					a_semaphore.release();
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		};

		Thread b = new Thread()
		{

			public void run()
			{
				try
				{
					a_semaphore.acquire();
					System.out.println("b");
					b_semaphore.release();

				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};

		Thread c = new Thread()
		{
			public void run()
			{
				try
				{
					b_semaphore.acquire();
					System.out.println("c");
					c_semaphore.release();
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		};

		a.start();
		b.start();
		c.start();
	}
}
