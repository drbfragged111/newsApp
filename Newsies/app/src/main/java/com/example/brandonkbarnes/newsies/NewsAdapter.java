package com.example.brandonkbarnes.newsies;

/**
 * Created by Brandon on 12/3/2017.
 */

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news article
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News>{

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news articles, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of news articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_view, parent, false);
        }

        // Find the article at the given position in the list of news articles
        News newNews = getItem(position);

        // Get the original headline string from the news article
        String mainHeadline = newNews.getHeadline();

        //Get the original author string from the news article
        String mainAuthor = newNews.getAuthor();

        //Get the original category string from the news article
        String mainCategory = newNews.getCategory();

        //Get the original date and time that the article was posted
        String mainTime = newNews.getTime();

        // Find the TextView with view ID headline
        TextView headline = (TextView) listItemView.findViewById(R.id.headline);
        // Display the headline of the current article in that TextView
        headline.setText(mainHeadline);

        // Find the TextView with view ID author
        TextView author = (TextView) listItemView.findViewById(R.id.author);
        // Display the author of the current article in that TextView
        author.setText(mainAuthor);

        // Find the TextView with view ID section
        TextView category = (TextView) listItemView.findViewById(R.id.section);
        // Display the author of the current article in that TextView
        category.setText(mainCategory);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(mainTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = new SimpleDateFormat("MMM dd, yyyy").format(date);
        // Display the date that the current article was posted in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "04:30PM")
        Date time = null;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(mainTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = new SimpleDateFormat("HH:mm:ss").format(time);
        // Display the time that the current article was posted in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
