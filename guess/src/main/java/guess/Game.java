package guess;

/**
 * Created by guansheng.fu on 14-2-26.
 */
public class Game {

	private String secret;

	private int guessTime = 0;

	public Game( String secret ){
		this.secret = secret;
	}

	public String guess( String g ){
		if( ++guessTime < 6 ){
			return guessImpl( g );
		}else{
			return "You lose!";
		}
	}

	private String guessImpl( String g ){

		int totalMatchCount = totalMatch(g);

		int haflMathCount = halfMatch(g);

		if( totalMatchCount == 4 )
			return "You win!";
		else
			return "x" + totalMatchCount + "y" + haflMathCount;
	}

	private int totalMatch( String g ){
		int matchCount = 0;
		for( int i=0;i<4;++i ){
			if( g.charAt(i) == secret.charAt(i) )
			{
				++matchCount;
			}
		}
		return matchCount;
	}

	private int halfMatch( String g ){
		int matchCount = 0;
		for( int i=0;i<4;++i ){
			char toFind = g.charAt(i);
			for( int j=0;j<4;++j ){
				if( i != j ){
					if( toFind == secret.charAt(j) ){
						++matchCount;
						break;
					}
				}
			}
		}
		return matchCount;
	}
}
