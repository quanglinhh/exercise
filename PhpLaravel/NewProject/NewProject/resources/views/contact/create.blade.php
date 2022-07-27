@extends('master')
@section('content')
<div class="row">
            <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            Thêm mới Contact
                        </header>
                        <div class="panel-body">
                            @isset($message)
                                <div class="message-alert" style="color: red; text-align: center; font-weight: bold;">
                                {{ $message }}
                                </div>
                            @endisset
                            
                            <div class="position-center">
                                <form method="post" action="{{ route('contact.store') }}">
                                @csrf
                                <div class="form-group">
                                    <label for="first_name">First name</label>
                                    <input type="text" class="form-control" name="first_name" id="first_name" placeholder="First name">
                                </div>
                                <div class="form-group">
                                    <label for="last_name">Last name</label>
                                    <input type="text" class="form-control" name="last_name" id="last_name" placeholder="Last name">
                                </div>
                                <div class="form-group">
                                    <label for="email">Email address</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label for="city">City</label>
                                    <input type="text" class="form-control" name="city" id="city" placeholder="City">
                                </div>
                                <div class="form-group">
                                    <label for="country">Country</label>
                                    <input type="text" class="form-control" name="country" id="country" placeholder="Country">
                                </div>
                                <div class="form-group">
                                    <label for="job_title">Job title</label>
                                    <input type="text" class="form-control" name="job_title" id="job_title" placeholder="Job title">
                                </div>
                                <button type="submit" class="btn btn-info" name="btnSubmit">Submit</button>
                                <button type="button" class="btn btn-info" name="btnBack">
                                    <a href="{{ route('contact.index') }}">Back</a>
                                </button>
                            </form>
                            </div>

                        </div>
                    </section>

            </div>
        </div>
@endsection
        
