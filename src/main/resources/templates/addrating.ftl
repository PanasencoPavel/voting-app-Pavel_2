<#import "parts/common_nobar.ftl" as c>
<@c.page>
    <div class="jumbotron text-center my-3">
        <h3>Rate the shop</h3>
        <form method="post" action="/shop/${coffeeShop.get().getId()}/addrating">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="input-group mb-3">
                <label>
                    <input type="text" name="headingText" placeholder="Heading text" class="form-control">
                </label>
            </div>
            <div class="input-group mb-3">
                <textarea class="form-control" type="text" name="feedbackText" placeholder="Feedback text"></textarea>
            </div>
            <div class="row input-group">
                <div class="col-12 col-sm-6 col-md-4 col-lg-3"><label> Coffee
                        <select name="coffeeNote" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </label></div>
                <div class="col-12 col-sm-6 col-md-4 col-lg-3"><label> Food
                        <select name="foodNote" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </label></div>
                <div class="col-12 col-sm-6 col-md-4 col-lg-3"><label> Atmosphere
                        <select name="atmosphereNote" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </label></div>
                <div class="col-12 col-sm-6 col-md-4 col-lg-3"><label> Service
                        <select name="serviceNote" class="form-control">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </label></div>
            </div>
            <div class="input-group mb-3 my-3">
                <button type="submit" class="btn btn-success ">Submit</button>
            </div>
        </form>
</@c.page>