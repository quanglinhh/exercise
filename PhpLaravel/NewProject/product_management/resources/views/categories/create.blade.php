@extends('categories.layout')
@section('content')
    <div class="row">
        <div class="col-lg-12">
            <h2 class="text-center">Add category</h2>
        </div>
        <div class="col-lg-12 text-center" style="margin-top: 10px;margin-bottom: 10px;">
            <a class="btn btn-primary" href="{{ route('categories.index') }}">Back</a>

        </div>

    </div>
    @if ($errors->any())
    <div class="alert alert-danger">
        <strong>Oops! </strong>There were some problem with your input.<br><br>
        <ul>
            @foreach($errors->all() as $error)
            <li>{{ $error }}</li>
            @endforeach
        </ul>
    </div>
    @endif
    <form action="{{ route('categories.store') }}" method="POST">
        @csrf
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12">
                <div class="form-group">
                    <strong>Category Name:</strong>
                    <input type="text" name="category_name" class="form-control"
                           placeholder="category Name">
                </div>
             

                </div>

                <div class="col-xs-12 col-sm-12 col-md-12 text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>

            </div>
        </div>
    </form>
@endsection