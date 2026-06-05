import java.awt.geom.Point2D;
import java.io.File;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.BasicModelEditor;
import com.change_vision.jude.api.inf.editor.ClassDiagramEditor;
import com.change_vision.jude.api.inf.editor.ModelEditorFactory;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.editor.UseCaseDiagramEditor;
import com.change_vision.jude.api.inf.editor.UseCaseModelEditor;
import com.change_vision.jude.api.inf.model.IClass;
import com.change_vision.jude.api.inf.model.IElement;
import com.change_vision.jude.api.inf.model.IModel;
import com.change_vision.jude.api.inf.model.IPackage;
import com.change_vision.jude.api.inf.model.IUseCase;
import com.change_vision.jude.api.inf.presentation.INodePresentation;
import com.change_vision.jude.api.inf.project.ProjectAccessor;

public class CreateLab05AstahDiagrams {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			throw new IllegalArgumentException("Usage: CreateLab05AstahDiagrams <class-asta-path> <usecase-asta-path>");
		}

		createClassDiagram(args[0]);
		createUseCaseDiagram(args[1]);
	}

	private static void createClassDiagram(String path) throws Exception {
		deleteIfExists(path);

		ProjectAccessor accessor = AstahAPI.getAstahAPI().getProjectAccessor();
		accessor.create(path);
		IModel project = accessor.getProject();

		TransactionManager.beginTransaction();
		try {
			BasicModelEditor model = ModelEditorFactory.getBasicModelEditor();
			IPackage aims = model.createPackage(project, "hust.soict.dsai.aims");
			IPackage mediaPkg = model.createPackage(aims, "media");
			IPackage cartPkg = model.createPackage(aims, "cart");
			IPackage storePkg = model.createPackage(aims, "store");
			IPackage screenPkg = model.createPackage(aims, "screen");
			IPackage exceptionPkg = model.createPackage(aims, "exception");

			IClass media = model.createClass(mediaPkg, "Media");
			model.createAttribute(media, "id", "int");
			model.createAttribute(media, "title", "String");
			model.createAttribute(media, "category", "String");
			model.createAttribute(media, "cost", "float");
			model.createOperation(media, "equals", "boolean");

			IClass playable = model.createInterface(mediaPkg, "Playable");
			model.createOperation(playable, "play() throws PlayerException", "void");

			IClass disc = model.createClass(mediaPkg, "Disc");
			model.createAttribute(disc, "director", "String");
			model.createAttribute(disc, "length", "int");

			IClass dvd = model.createClass(mediaPkg, "DigitalVideoDisc");
			IClass cd = model.createClass(mediaPkg, "CompactDisc");
			model.createAttribute(cd, "artist", "String");
			model.createAttribute(cd, "tracks", "ArrayList<Track>");
			IClass track = model.createClass(mediaPkg, "Track");
			model.createAttribute(track, "title", "String");
			model.createAttribute(track, "length", "int");
			IClass book = model.createClass(mediaPkg, "Book");
			model.createAttribute(book, "authors", "ArrayList<String>");

			IClass cart = model.createClass(cartPkg, "Cart");
			model.createAttribute(cart, "itemsOrdered", "ObservableList<Media>");
			IClass store = model.createClass(storePkg, "Store");
			model.createAttribute(store, "itemsInStore", "ArrayList<Media>");

			IClass playerException = model.createClass(exceptionPkg, "PlayerException");
			IClass javaException = model.createClass(exceptionPkg, "java.lang.Exception");

			IClass storeScreen = model.createClass(screenPkg, "StoreScreen");
			IClass mediaStore = model.createClass(screenPkg, "MediaStore");
			IClass cartScreen = model.createClass(screenPkg, "CartScreen");
			IClass cartController = model.createClass(screenPkg, "CartScreenController");
			IClass addItem = model.createClass(screenPkg, "AddItemToStoreScreen");
			addItem.setAbstract(true);
			IClass addBook = model.createClass(screenPkg, "AddBookToStoreScreen");
			IClass addCd = model.createClass(screenPkg, "AddCompactDiscToStoreScreen");
			IClass addDvd = model.createClass(screenPkg, "AddDigitalVideoDiscToStoreScreen");

			model.createGeneralization(disc, media, "");
			model.createGeneralization(dvd, disc, "");
			model.createGeneralization(cd, disc, "");
			model.createGeneralization(book, media, "");
			model.createGeneralization(playerException, javaException, "");
			model.createGeneralization(addBook, addItem, "");
			model.createGeneralization(addCd, addItem, "");
			model.createGeneralization(addDvd, addItem, "");
			model.createRealization(dvd, playable, "");
			model.createRealization(cd, playable, "");
			model.createRealization(track, playable, "");
			model.createAssociation(cart, media, "", "itemsOrdered", "media");
			model.createAssociation(store, media, "", "itemsInStore", "media");
			model.createAssociation(cd, track, "", "tracks", "track");
			model.createAssociation(storeScreen, store, "", "storeScreen", "store");
			model.createAssociation(storeScreen, cart, "", "storeScreen", "cart");
			model.createAssociation(mediaStore, media, "", "mediaStore", "media");
			model.createAssociation(mediaStore, cart, "", "mediaStore", "cart");
			model.createAssociation(cartScreen, cart, "", "cartScreen", "cart");
			model.createAssociation(cartController, cart, "", "controller", "cart");
			model.createAssociation(addItem, store, "", "addScreen", "store");
			model.createAssociation(addItem, cart, "", "addScreen", "cart");
			model.createDependency(playable, playerException, "throws");

			ClassDiagramEditor diagram = accessor.getDiagramEditorFactory().getClassDiagramEditor();
			diagram.createClassDiagram(aims, "Lab05 AIMS Class Diagram");

			INodePresentation pMedia = node(diagram, media, 360, 30);
			INodePresentation pDisc = node(diagram, disc, 360, 170);
			INodePresentation pDvd = node(diagram, dvd, 170, 310);
			INodePresentation pCd = node(diagram, cd, 360, 310);
			INodePresentation pBook = node(diagram, book, 580, 310);
			INodePresentation pTrack = node(diagram, track, 360, 470);
			INodePresentation pPlayable = node(diagram, playable, 40, 170);
			INodePresentation pCart = node(diagram, cart, 820, 30);
			INodePresentation pStore = node(diagram, store, 820, 170);
			INodePresentation pStoreScreen = node(diagram, storeScreen, 820, 330);
			INodePresentation pMediaStore = node(diagram, mediaStore, 1070, 330);
			INodePresentation pCartScreen = node(diagram, cartScreen, 820, 500);
			INodePresentation pController = node(diagram, cartController, 1070, 500);
			INodePresentation pAddItem = node(diagram, addItem, 1320, 170);
			INodePresentation pAddBook = node(diagram, addBook, 1200, 330);
			INodePresentation pAddCd = node(diagram, addCd, 1420, 330);
			INodePresentation pAddDvd = node(diagram, addDvd, 1640, 330);
			INodePresentation pPlayerException = node(diagram, playerException, 80, 500);
			INodePresentation pJavaException = node(diagram, javaException, 80, 380);

			link(diagram, disc, pMedia, pDisc);
			link(diagram, dvd, pDisc, pDvd);
			link(diagram, cd, pDisc, pCd);
			link(diagram, book, pMedia, pBook);
			link(diagram, playerException, pJavaException, pPlayerException);
			link(diagram, addBook, pAddItem, pAddBook);
			link(diagram, addCd, pAddItem, pAddCd);
			link(diagram, addDvd, pAddItem, pAddDvd);
			link(diagram, dvd, pPlayable, pDvd);
			link(diagram, cd, pPlayable, pCd);
			link(diagram, track, pPlayable, pTrack);
			link(diagram, cart, pCart, pMedia);
			link(diagram, store, pStore, pMedia);
			link(diagram, cd, pCd, pTrack);
			link(diagram, storeScreen, pStoreScreen, pStore);
			link(diagram, storeScreen, pStoreScreen, pCart);
			link(diagram, mediaStore, pMediaStore, pMedia);
			link(diagram, mediaStore, pMediaStore, pCart);
			link(diagram, cartScreen, pCartScreen, pCart);
			link(diagram, cartController, pController, pCart);
			link(diagram, addItem, pAddItem, pStore);
			link(diagram, addItem, pAddItem, pCart);
			link(diagram, playable, pPlayable, pPlayerException);

			TransactionManager.endTransaction();
			accessor.save();
		} catch (Throwable t) {
			TransactionManager.abortTransaction();
			throw t;
		} finally {
			accessor.close();
		}
	}

	private static void createUseCaseDiagram(String path) throws Exception {
		deleteIfExists(path);

		ProjectAccessor accessor = AstahAPI.getAstahAPI().getProjectAccessor();
		accessor.create(path);
		IModel project = accessor.getProject();

		TransactionManager.beginTransaction();
		try {
			BasicModelEditor basic = ModelEditorFactory.getBasicModelEditor();
			UseCaseModelEditor useCaseModel = ModelEditorFactory.getUseCaseModelEditor();
			IPackage pkg = basic.createPackage(project, "AIMS Lab05 Requirements");

			IClass user = useCaseModel.createActor(pkg, "User");
			IUseCase viewStore = useCaseModel.createUseCase(pkg, "View Store");
			IUseCase addToCart = useCaseModel.createUseCase(pkg, "Add Media to Cart");
			IUseCase playMedia = useCaseModel.createUseCase(pkg, "Play Media");
			IUseCase viewCart = useCaseModel.createUseCase(pkg, "View Cart");
			IUseCase filterCart = useCaseModel.createUseCase(pkg, "Filter Cart");
			IUseCase removeCart = useCaseModel.createUseCase(pkg, "Remove Media from Cart");
			IUseCase placeOrder = useCaseModel.createUseCase(pkg, "Place Order");
			IUseCase updateStore = useCaseModel.createUseCase(pkg, "Update Store");
			IUseCase addBook = useCaseModel.createUseCase(pkg, "Add Book to Store");
			IUseCase addCd = useCaseModel.createUseCase(pkg, "Add CD to Store");
			IUseCase addDvd = useCaseModel.createUseCase(pkg, "Add DVD to Store");

			basic.createAssociation(user, viewStore, "", "", "");
			basic.createAssociation(user, viewCart, "", "", "");
			basic.createAssociation(user, updateStore, "", "", "");
			useCaseModel.createInclude(viewStore, addToCart, "");
			useCaseModel.createInclude(viewStore, playMedia, "");
			useCaseModel.createInclude(viewCart, filterCart, "");
			useCaseModel.createInclude(viewCart, removeCart, "");
			useCaseModel.createInclude(viewCart, placeOrder, "");
			useCaseModel.createInclude(viewCart, playMedia, "");
			useCaseModel.createInclude(updateStore, addBook, "");
			useCaseModel.createInclude(updateStore, addCd, "");
			useCaseModel.createInclude(updateStore, addDvd, "");

			UseCaseDiagramEditor diagram = accessor.getDiagramEditorFactory().getUseCaseDiagramEditor();
			diagram.createUseCaseDiagram(pkg, "Lab05 AIMS Use Case Diagram");

			INodePresentation pUser = node(diagram, user, 30, 270);
			INodePresentation pViewStore = node(diagram, viewStore, 260, 80);
			INodePresentation pAddToCart = node(diagram, addToCart, 520, 30);
			INodePresentation pPlay = node(diagram, playMedia, 520, 130);
			INodePresentation pViewCart = node(diagram, viewCart, 260, 300);
			INodePresentation pFilter = node(diagram, filterCart, 520, 240);
			INodePresentation pRemove = node(diagram, removeCart, 520, 330);
			INodePresentation pOrder = node(diagram, placeOrder, 520, 420);
			INodePresentation pUpdate = node(diagram, updateStore, 260, 540);
			INodePresentation pAddBook = node(diagram, addBook, 520, 540);
			INodePresentation pAddCd = node(diagram, addCd, 520, 630);
			INodePresentation pAddDvd = node(diagram, addDvd, 520, 720);

			link(diagram, user, pUser, pViewStore);
			link(diagram, user, pUser, pViewCart);
			link(diagram, user, pUser, pUpdate);
			link(diagram, viewStore, pViewStore, pAddToCart);
			link(diagram, viewStore, pViewStore, pPlay);
			link(diagram, viewCart, pViewCart, pFilter);
			link(diagram, viewCart, pViewCart, pRemove);
			link(diagram, viewCart, pViewCart, pOrder);
			link(diagram, viewCart, pViewCart, pPlay);
			link(diagram, updateStore, pUpdate, pAddBook);
			link(diagram, updateStore, pUpdate, pAddCd);
			link(diagram, updateStore, pUpdate, pAddDvd);

			TransactionManager.endTransaction();
			accessor.save();
		} catch (Throwable t) {
			TransactionManager.abortTransaction();
			throw t;
		} finally {
			accessor.close();
		}
	}

	private static INodePresentation node(com.change_vision.jude.api.inf.editor.StructureDiagramEditor editor,
			IElement element, double x, double y) throws Exception {
		return editor.createNodePresentation(element, new Point2D.Double(x, y));
	}

	private static void link(com.change_vision.jude.api.inf.editor.StructureDiagramEditor editor,
			IElement element, INodePresentation from, INodePresentation to) throws Exception {
		try {
			editor.createLinkPresentation(element, from, to);
		} catch (Exception ignored) {
			// Some model links are already represented by the target element in Astah API.
		}
	}

	private static void deleteIfExists(String path) {
		File file = new File(path);
		if (file.exists() && !file.delete()) {
			throw new IllegalStateException("Cannot overwrite " + path);
		}
	}
}
