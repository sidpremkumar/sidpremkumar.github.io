# We are importing the Flask module and render_template module here.
#  - We will use Flask to start our webserver.
#  - We will use render_template to template our HTML
from flask import Flask, render_template, request

# We're creating our flask app object here. This is what will be used to create the server
app = Flask(__name__)

# This will be our makeshift database
data_base = {}

@app.route("/", methods=['GET'])
def index():
    # This will be the first page our users see

# If we are calling the function from the command line
if __name__ == "__main__":
    # Start our app
    app.run()
