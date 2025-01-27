import { ADD_NOTE, DELETE_NOTE, MODIFY_NOTE } from "../actions/actions";

const initialState = {
    notes: [
        {
            title: "my first note",
            description: "my first description"
        },
        {
            title: "my second note",
            description: "my second description"
        }
    ],
    warnings: ["test", "test"]

}

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_NOTE:
            return {
                ...state,
                notes: [
                    ...state.notes,
                    {
                        title: action.payload.title,
                        description: action.payload.description
                    },
                ]
            };
        case DELETE_NOTE: 
            return {
                ...state,
                notes: state.notes.filter((_,idx) => idx !== action.payload.id)
            }
        case MODIFY_NOTE: 
            return {
                ...state,
                notes: state.notes.map((note, index) => 
                    index === action.payload.id ?
                    { ...note, title: action.payload.title, description: action.payload.description}
                    : note
                )
            };
        default:
            return state;
    }
}

export default rootReducer;