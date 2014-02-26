package guess;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GameTest
{
	@Test
	public void should_return_youwin_when_guess_correct(){
		// give
		Game game = new Game("1234");

		// when
		String output = game.guess("1234");

		// then
		Assert.assertEquals("You win!", output);
	}


	@Test
	public void should_return_lose_when_guess_failure(){
		// give
		Game game = new Game("1234");

		// when
		String output = null;
		for( int i=0;i<6;++i ){
			output = game.guess("4321");
		}

		// then
		Assert.assertEquals("You lose!", output);
	}

	@Test
	public void should_not_return_lose_when_times_less_six(){
		// give
		Game game = new Game("1234");

		// when
		String output;
		for( int i=0;i<5;++i ){
			output = game.guess("4321");
			Assert.assertNotSame("You lose!", output);
		}

	}

	@Test
	public void should_return_xA_when_matches_A(){
		// give
		Game game = new Game("1234");

		// when
		String matches_one = game.guess("1890");
		String matches_two = game.guess("1290");
		String matches_three = game.guess("1230");

		// when
		Assert.assertEquals("x1",matches_one.substring(0,2));
		Assert.assertEquals("x2",matches_two.substring(0,2));
		Assert.assertEquals("x3",matches_three.substring(0,2));
	}

	@Test
	public void shoul_return_yB_when_half_matches_B(){
		// give
		Game game = new Game("1234");

		// when
		String half_matches_one = game.guess("4567");
		String half_matches_two = game.guess("4367");
		String half_matches_three = game.guess("4327");
		String half_matches_four = game.guess("4321");

		//
		Assert.assertEquals("y1",half_matches_one.substring(2));
		Assert.assertEquals("y2",half_matches_two.substring(2));
		Assert.assertEquals("y3",half_matches_three.substring(2));
		Assert.assertEquals("y4",half_matches_four.substring(2));
	}
}
