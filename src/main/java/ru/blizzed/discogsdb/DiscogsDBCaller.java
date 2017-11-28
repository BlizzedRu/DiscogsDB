package ru.blizzed.discogsdb;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.blizzed.discogsdb.model.Error;

import java.io.IOException;

public final class DiscogsDBCaller<ResultType> {

    public interface Listener<ResultType> {
        default void onComplete(ResultType result, DiscogsDBCaller<ResultType> discogsDBCaller) {
        }

        default void onError(Error error, DiscogsDBCaller<ResultType> discogsDBCaller) {
        }

        default void onFailure(DiscogsDBCallException e, DiscogsDBCaller<ResultType> discogsDBCaller) {
        }
    }

    private Call<ResultType> call;

    public DiscogsDBCaller(Call<ResultType> call) {
        this.call = call;
    }

    public ResultType execute() throws DiscogsDBCallException, DiscogsDBErrorException {
        try {
            Response<ResultType> response = call.execute();
            if (response.isSuccessful())
                return response.body();
            else throw new DiscogsDBErrorException(parseError(response));
        } catch (IOException e) {
            throw new DiscogsDBCallException(e);
        }
    }

    public void execute(Listener<ResultType> listener) {
        call.enqueue(new Callback<ResultType>() {
            @Override
            public void onResponse(Call<ResultType> call, Response<ResultType> response) {
                if (response.isSuccessful()) listener.onComplete(response.body(), DiscogsDBCaller.this);
                else  {
                    try {
                        listener.onError(parseError(response), DiscogsDBCaller.this);
                    } catch (IOException e) {
                        listener.onFailure(new DiscogsDBCallException(e), DiscogsDBCaller.this);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResultType> call, Throwable throwable) {
                listener.onFailure(new DiscogsDBCallException(throwable), DiscogsDBCaller.this);
            }
        });
    }

    public void cancel() {
        if (!call.isCanceled() & !call.isExecuted())
            call.cancel();
    }

    private Error parseError(Response response) throws IOException {
        return DiscogsDBApi.getInstance().parseError(response.errorBody());
    }

}
