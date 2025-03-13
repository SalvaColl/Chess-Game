project('chess-game', 'java')

sources = [
  'src/main/Mouse.java',
  'src/main/Type.java',
  'src/main/Main.java',
  'src/main/Board.java',
  'src/main/GamePanel.java',
  'src/piece/Knight.java',
  'src/piece/Rook.java',
  'src/piece/Bishop.java',
  'src/piece/Queen.java',
  'src/piece/King.java',
  'src/piece/Piece.java',
  'src/piece/Pawn.java'
]

resources = structured_sources([],{ 'images': files(
  'src/resources/images/b-bishop.png',
  'src/resources/images/w-knight.png',
  'src/resources/images/w-pawn.png',
  'src/resources/images/b-pawn.png',
  'src/resources/images/w-rook.png',
  'src/resources/images/b-rook.png',
  'src/resources/images/w-bishop.png',
  'src/resources/images/b-king.png',
  'src/resources/images/b-queen.png',
  'src/resources/images/b-knight.png',
  'src/resources/images/w-king.png',
  'src/resources/images/w-queen.png'
)})

game = jar(
  meson.project_name(),
  sources,
  main_class: 'main.Main',
  java_resources: resources
)


