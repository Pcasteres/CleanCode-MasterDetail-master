package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoryItem;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListViewModel;

public interface CategoryContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CategoryViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void fetchCategoryData();

        void selectProductListData(CategoryItem item);

    }

    interface Model {
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);

        List<CategoryItem> fetchProductListData();
    }

}
