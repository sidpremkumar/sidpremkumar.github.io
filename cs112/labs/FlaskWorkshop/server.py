# We are importing the Flask module and render_template module here.
#  - We will use Flask to start our webserver.
#  - We will use render_template to template our HTML
from flask import Flask, render_template, request

# We're creating our flask app object here. This is what will be used to create the server
app = Flask(__name__)

data_base = {}

@app.route("/", methods=['GET'])
def index():
    # This will be the first page our users see
    return render_template('index.html')

@app.route("/login", methods=['POST'])
def login():
    # This will be the login method

    # Check if we have a user with the creds
    username = request.form['username']
    password = request.form['password']

    import pdb; pdb.set_trace()
    if username in data_base:
        # We have a user with the same username
        if password == data_base[username]:
            # This user has the correct credentials
            # This will be the page that users see when they login
            return render_template('user_page.html', username=username)
        # The client has the wrong password
        return render_template('fail_page.html')

    # Else our user doesnt exit in our database and we should ask
    # them if they want to create an account
    return render_template('create_account.html')

@app.route("/create_account", methods=['POST'])
def create_account():
    # This will be the method to create an account

    # Grab our values
    username = request.form['username']
    password = request.form['password']

    # Add them to our dictionary
    data_base[username] = password

    # Return the username page
    return render_template('user_page.html', username=username)


# If we are calling the function from the command line
if __name__ == "__main__":
    # Start our app
    app.run()
