# countrylistexam
<p float="left">
<img src="https://user-images.githubusercontent.com/98274676/150689948-aea3879b-9f5b-459a-807e-7a9d4ec4070b.PNG" width="250" />
<img src="https://user-images.githubusercontent.com/98274676/150689956-21b71537-a396-4541-8b8e-d950b6c91025.PNG" width="250" />
<img src="https://user-images.githubusercontent.com/98274676/150689968-a6df2857-8663-4765-820b-32dfb70b0034.PNG" width="250" />
</p>

Libraries used
Retrofit2/RxJava2 for asynchronous api calls
Dagger+Hilt for dependency injection
DataBinding
Jetpack Navigation
Glide for Image Loading

Architecture flow (MVVM Clean Architecture + Repository Pattern)
View <-> ViewModel <-> Interactors/Use Cases <-> Repository <-> Local/Remote Data Source

Features:
Load list of countries returned from API https://restcountries.com/v3.1/
Display Country Details, flag, coat of arms, capital, region, etc.
Ability to filter out countried based on keyword on search bar
Handles loading/error displays
Data persistence on orientation change
Debug/Release flavor
Has data object mapper that converts Network models to Business models (CountryDataMapper.kt)
