# Flickster
This project lets users view a list of movies sourced from the The Movie Database API.

## Part 1

### User Stories

#### REQUIRED (10pts)
- [ X] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [ X] (2pts) Views should be responsive for both landscape/portrait mode.
   - [ X] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [ X] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [ ] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.com/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [ ] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

<img src="http://g.recordit.co/2m3H2meORb.gif" width=300><br>

### Notes
Had an issue was with the JSON parsing in the model. My movies were not being parsed due to a minor error(adding an _ to a key).

### Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
