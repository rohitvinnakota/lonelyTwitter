
		package ca.ualberta.cs.lonelytwitter;

		import java.io.BufferedReader;
		import java.io.BufferedWriter;
		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.io.FileOutputStream;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.io.OutputStreamWriter;
		import java.util.ArrayList;
		import java.util.Date;
		import android.app.Activity;
		import android.content.Context;
		import android.os.Bundle;
		import android.view.View;
		import android.widget.ArrayAdapter;
		import android.widget.Button;
		import android.widget.EditText;
		import android.widget.ListView;

		import com.google.gson.Gson;
		import com.google.gson.reflect.TypeToken;

		/**
		 * This class is the main view class of teh project. <br> In this class, teh user interaction
		 * and file mainpulation is performed.
		 * All files are in the form of "json" files that are stored in the Emulator's
		 * accessible from Android Device Monitor:
		 * <pre>
		 *     pre-formatted test: <br>
		 *         File Explores -> data -> data -> ca.ualberta.cs.lonelytwitter -> files -> files.sav.
		 * </pre>
		 * <code> begin <br>
		 *     some psuedo code hre <br>
		 * end.</code>
		 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant.
		 * <ul>
		 *     <li>item 1</li>
		 *     <li>item 2</li>
		 *     <li>item 3</li>
		 * </ul>
		 * <ol>
		 *     <li>item 1</li>
		 *     <li>item 2</li>
		 *     <li>item 3</li>
		 * </ol>
		 *
		 * @author vinnakot
		 * @version 1.4.2
		 * @since 1.0
		 */
		public class LonelyTwitterActivity extends Activity {
			/**
			 * The file that all the tweets are saved  there.
			 * The format of the file is JSON.
			 * @see #loadFromFile()
			 * @see #saveInFile()
			 */

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private enum TweetListOrdering {DATE_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING,
		TEXT_DESCENDING};
	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

			/**
			 * Called when the activity is first created
 			 * @param savedInstanceState
             */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		Button clearButton = (Button) findViewById(R.id.clear);

		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				text = trimExtraSpaces(text);
				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

			/**
			 * Removes extra spaces in the given string
			 * @param inputString input string
             * @return string without extra spaces
             */
	private String trimExtraSpaces(String inputString){
		inputString = inputString.replaceAll("\\s+"," ");
		return inputString;
	}

	private void sortTweetListItems(TweetListOrdering ordering){

	}

			/**
			 * Loads tweets from file.
			 * @throws TweetTooLongException if the tweet is too long
			 * @exception FileNotFoundException if the file is not created
			 */

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			// Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// 2017-01-26 17:53:59
			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>() {
			}.getType());
			fis.close();
		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

			/**
			 * Saves tweets in file in JSON format.
			 * @throws FileNotFoundException if folder does not exist
			 */

	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}