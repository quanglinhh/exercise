@extends('layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-12">
            <h2 class="text-center">Add New Book</h2>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            @if ($errors->any())
                <div class="alert alert-danger">
                    <strong>Oops! </strong>There were some problems with your input.<br><br>
                    <ul>
                        @foreach($errors->all() as $error)
                            <li>{{ $error }}</li>
                        @endforeach
                    </ul>
                </div>
            @endif

            <form action="{{ route('books.store') }}" method="POST">
                @csrf
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="form-group">
                    <label for="authorid">Author ID:</label>
                    <input type="number" class="form-control" id="authorid" name="authorid">
                </div>
                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input type="text" class="form-control" id="isbn" name="isbn">
                </div>
                <div class="form-group">
                    <label for="pub_year">Publication Year:</label>
                    <input type="text" class="form-control" id="pub_year" name="pub_year">
                </div>
                <div class="form-group">
                    <label for="available">Available:</label>
                    <input type="checkbox" id="available" name="available" value="1">
                </div>
                <button type="submit" class="btn btn-primary">Add Book</button>
            </form>
        </div>
    </div>
@endsection
