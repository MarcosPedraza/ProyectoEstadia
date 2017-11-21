package com.example.marcospedraza.proyectoestadia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity  {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    TextView txtUserName, txtEmail;
    CircleImageView userPhoto;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // txtUserName = (TextView)findViewById(R.id.username);
       // txtEmail= (TextView)findViewById(R.id.email);
        //userPhoto=(CircleImageView)findViewById(R.id.circle_image);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        txtUserName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.username);
        txtEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.email);
        userPhoto = (CircleImageView)navigationView.getHeaderView(0).findViewById(R.id.circle_image);





        if (navigationView != null) {
            setupNavigationDrawerContent(navigationView);
        }

        setupNavigationDrawerContent(navigationView);

        setFragment(0);

        mAuth =FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null)
                {
                    setUserData(user);
                }
                else
                {
                    goToLogin();
                }

            }
        };


    }

    private void goToLogin() {

        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void setUserData(FirebaseUser user) {

        txtUserName.setText(user.getDisplayName());
        txtEmail.setText(user.getEmail());
        Glide.with(getApplicationContext())
                .load(user.getPhotoUrl())
                .into(userPhoto);

    }


    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // infla el menu. agregar items al actionbar si existe uno
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);


        //SearchView en actionbar (hay que obtener el MenuItem por su id
        // y inicializar el searchView asignando el item de seachView que tiene asignada la propiedad de searchview en el layout de menu
        //luego asignamos la interfaz OnQueryTextListener


        final MenuItem itemSearch = menu.findItem(R.id.item_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(itemSearch);

        searchView.setQueryHint("Buscar en Lugares");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.setQuery("",false);
                searchView.setIconified(true);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemid = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        if(itemid == R.id.item_search)
        {
            Toast.makeText(getApplicationContext(),"click en buscar",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {


                navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.nav_main:
                                menuItem.setChecked(true);

                                setFragment(0); //le tengo que pasar un int a el metodo para que ejecute el caso en el witch


                                Toast.makeText(getApplicationContext(),"fragment de inicio",Toast.LENGTH_SHORT).show();
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_lugares:
                                menuItem.setChecked(true);
                                setFragment(1);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.nav_eventos:
                                menuItem.setChecked(true);

                                setFragment(2);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;

                            case R.id.nav_account:
                                menuItem.setCheckable(true);
                                setFragment(3);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                        }
                        return true;
                    }
                });
    }

    public void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                PlaceHolderFragment inboxFragment = new PlaceHolderFragment();
                fragmentTransaction.replace(R.id.main_content, inboxFragment);
                fragmentTransaction.commit();
                break;

            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentFavoritos fragmentFavoritos = new FragmentFavoritos();
                fragmentTransaction.replace(R.id.main_content,fragmentFavoritos);
                fragmentTransaction.commit();

                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentEventos fragmentoEventos = new FragmentEventos();
                fragmentTransaction.replace(R.id.main_content,fragmentoEventos);
                fragmentTransaction.commit();
                break;

            case 3:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentAccount fragmentoAccount = new FragmentAccount();
                fragmentTransaction.replace(R.id.main_content,fragmentoAccount);
                fragmentTransaction.commit();

                break;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mAuthStateListener != null)
        {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
}
