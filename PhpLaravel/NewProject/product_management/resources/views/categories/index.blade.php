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
            <input type="text" class="form-control" id="searchInput" placeholder="Search by title...">
        </div>
        <div class="col-lg-3">
            <button type="button" class="btn btn-primary" id="searchButton">Search</button>
        </div>
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

@section('scripts')
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script>
        $(document).ready(function(){
            $('#searchButton').click(function(){
                var searchValue = $('#searchInput').val().toLowerCase();
                $('#booksTable tbody tr').hide();
                $('#booksTable tbody tr').each(function(){
                    var title = $(this).find('td:first').text().toLowerCase();
                    if(title.includes(searchValue)){
                        $(this).show();
                    }
                });
            });

            // Reset search when input is empty
            $('#searchInput').keyup(function(){
                var searchValue = $(this).val().toLowerCase();
                if(searchValue == ''){
                    $('#booksTable tbody tr').show();
                }
            });
        });
    </script>
@endsection