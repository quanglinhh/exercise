@extends('layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-12">
            <h2 class="text-center">List of Books</h2>
        </div>
    </div>

    <div class="row mb-3">
        <div class="col-lg-6">
            <a href="{{ route('books.create') }}" class="btn btn-success">Add New Book</a>
        </div>
       
        <div class="col-lg-6">
            <form action="/search" method="GET">
                <input type="text" class="form-control" name="search" placeholder="Search by title...">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
    <div class="col-lg-3">
            <a href="{{ route('books.index') }}" class="btn btn-primary">List Book</a>
        </div>
    <div class="row">
        <div class="col-lg-12">
            <div id="booksTable">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Author ID</th>
                            <th>ISBN</th>
                            <th>Publication Year</th>
                            <th>Available</th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach ($books as $book)
                        <tr>
                            <td>{{ $book->title }}</td>
                            <td>{{ $book->authorid }}</td>
                            <td>{{ $book->ISBN }}</td>
                            <td>{{ $book->pub_year }}</td>
                            <td>{{ $book->available }}</td>
                        </tr>
                        @endforeach
                    </tbody>
                </table>
            </div>
        </div>
    </div>
@endsection
