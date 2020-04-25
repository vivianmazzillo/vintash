package turismo.maps.google;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoPlaceActivity extends AppCompatActivity {

    private TextView title, web_page, description,phone, type;
    private ImageView image;
    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_place);

        title = (TextView)findViewById(R.id.text_title);
        web_page = (TextView)findViewById(R.id.text_web_page);
        description = (TextView)findViewById(R.id.text_description);
        phone = (TextView)findViewById(R.id.text_phone);
        type = (TextView)findViewById(R.id.text_type);
        image = (ImageView)findViewById(R.id.image);
        regresar = (Button)findViewById(R.id.btn_regresar);

        String titleString = getIntent().getStringExtra("title");
        title.setText(titleString);

        String descriptionString = getIntent().getStringExtra("description");
        description.setText(descriptionString);

        String typeString = getIntent().getStringExtra("type");
        type.setText(typeString);

        String webPageString = getIntent().getStringExtra("page");
        web_page.setText(webPageString);
        Linkify.addLinks(web_page, Linkify.WEB_URLS);

        String phoneString = getIntent().getStringExtra("phone");
        phone.setText(phoneString);

        String imageString = getIntent().getStringExtra("image");

        Picasso.get().load(imageString).into(image);

        final String filterString = getIntent().getStringExtra("filter");

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity1.class);
                intent.putExtra("type",filterString);
                startActivity(intent);
            }
        });
    }
}
