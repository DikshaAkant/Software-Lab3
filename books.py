from flask import Flask, request, jsonify
app = Flask(__name__)
books = [
    {"id": 1, "title": "Python Basics", "author": "Amit"}
]
@app.route("/books", methods=["GET"])
def get_books():
    return jsonify(books), 200
@app.route("/books", methods=["POST"])
def add_book():
    data = request.get_json(silent=True)
    if not isinstance(data, dict):
        return jsonify({"error": "Request body must be valid JSON"}), 400
    title = data.get("title")
    author = data.get("author")
    if not isinstance(title, str) or not title.strip():
        return jsonify({"error": "Title is required"}), 400
    if not isinstance(author, str) or not author.strip():
        return jsonify({"error": "Author is required"}), 400
    book = {
        "id": max((b["id"] for b in books), default=0) + 1,
        "title": title.strip(),
        "author": author.strip()
    }
    books.append(book)
    return jsonify(book), 201
if __name__ == "__main__":
    app.run(debug=False, use_reloader=False)
