package vn.teko.utilities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constant {
	public static final String NULL_VALUE = "null";
	public static final String EMPTY_VALUE = "empty";
	public static final String SPACES_ONLY_VALUE = "spaces_only";
	public static final String LEADING_ENDING_SPACES_VALUE = "leading_ending_spaces";
	public static final String RANDOM_STRING_ALPHABET_VALUE = "random_alphabet";
	public static final String RANDOM_STRING_FROM_ALL_CHARACTERS_VALUE = "random_string_from_all_characters";
	public static final String CONTAIN_SPECIAL_CHARACTERS_VALUE = "contain_special_characters";
	public static final String CONTAIN_SPACE_VALUE = "contain_space_characters";
	public static final String RANDOM_DIACRITIC_MARK = "random_diacritic_mark";
	
	public static final String REMOVE_DIACRITIC_MARK = "no_diacritic_mark";
	public static final String UPPER_CASE = "upper_case";
	public static final String LOWER_CASE = "lower_case";
	
	
	public static final String CHECK_DATABASE_YES = "yes";
	public static final String CHECK_DATABASE_NO = "no";
	public static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_+{}:\\\"<>?`-=[]\\\\;'./,\"";
	public static final String UNICODE_CHARACTERS = "abcdefghijklmnopqrstuvwxyzáàạảãăắẳặẵâậẩấầêếềệểễưừửựứữơởờớợỡéèẹẻẽỉịĩíìổốồộỗ";
	public static final String SPACE_CHARACTERS = "   ";
	public static final String IMAGE_URI_SCHEMA = "data:image/{imageType};base64,";
	public static final String TEXT_URI_SCHEMA = "data:text/plain,";
	
	public static final int THREAD_SLEEP = 10000;
	
	public static final List<String> SALE_CHANNEL_TYPE_LIST = Stream.of("showroom", "agent", "online").collect(Collectors.toList());
	public static final List<Integer> SELLER_LIST = Stream.of(1,2).collect(Collectors.toList());
	
	public static final String RESPONSE_ID_FIELD = "id";
	public static final String DATABASE_MODEL_CLASS_VARIABLE = "database_entity";
	public static final String DATABASE_MODEL_CLASS_REFERENCE_VARIABLE = "database_entity_reference";
	public static final String DATATABLE_INPUT_LABEL = "inputField";
	public static final String DATATABLE_OUTPUT_LABEL = "outputField";
	
	//Entity name
	public static final String ENTITY_SALE_CHANNEL = "SaleChannelModel";
	public static final String ENTITY_SELLER = "SellerModel";
	public static final String ENTITY_SALE_CATEGORY = "MasterCategoryModel";
	public static final String ENTITY_BRAND = "BrandModel";
	
	//seller status
	public static final int SELLER_STATUS_ACTIVE = 1;
	public static final int SELLER_STATUS_INACTIVE = 0;
	
	public static final int STATUS_ACTIVE = 1;
	public static final int STATUS_INACTIVE = 0;	
	
	public static final int SERVER_STATUS_ERROR = 502;
	
	public static final String USER1 = "user1";
}
